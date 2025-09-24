package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.pojo.Users;
import com.design.employeesManagement.mapper.UsersMapper;
import com.design.employeesManagement.service.UsersService;
import com.design.employeesManagement.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.pojo.res.RestFulBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.employeesManagement.util.PageUtil;
import com.design.employeesManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since  22:21:49
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Users users: list){
                users.setImagesUrl("http://localhost:8087/file/"+users.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id);
        users.setImagesUrl("http://localhost:8087/file/"+users.getImages());
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getEmail()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("邮箱不能为空");
        }
        if(!users.getEmail().contains("@")){
            return RestFulBean.error("邮箱不合法");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getCardId()==null){
            return RestFulBean.error("身份证号码不能为空");
        }
        if(users.getCardId().trim().length()!=18){
            return RestFulBean.error("请输入18位身份证号码");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getImages()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(users.getAge()==null){
            return RestFulBean.error("年龄不能为空");
        }
        if(users.getBirthday()==null){
            return RestFulBean.error("出生日期不能为空");
        }
        if(users.getNation()==null){
            return RestFulBean.error("民族不能为空");
        }
        if(users.getNativePlace()==null){
            return RestFulBean.error("籍贯不能为空");
        }
        if(users.getPolitical()==null){
            return RestFulBean.error("政治面貌不能为空");
        }
        if(users.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        //13位时间戳 不可能重复
        long timeMillis=System.currentTimeMillis(); //当前系统时间戳
        String userNo=String.valueOf(timeMillis).substring(0,9);
        users.setUserNo("YG"+userNo);//自动生成11位员工编号
        users.setPassword("123456"); //密码默认为123456
        System.out.println(users);
        this.usersMapper.insert(users);//执行数据库的新增语句
        return RestFulBean.succ("注册成功,员工编号为YG"+userNo+"密码为123456请登录自行修改密码");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.usersMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Users>> getManagerList() {
        List<Users> list =usersMapper.getManagerList();
        return RestFulBean.succ(list);
    }

}
