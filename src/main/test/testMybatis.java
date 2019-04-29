import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.dao.News.IArchiveDao;
import com.qxlh.dao.News.INewsCateDao;
import com.qxlh.dao.News.INewsCateDao;
import com.qxlh.dao.News.INewsDao;
import com.qxlh.dao.common.ILinkDao;
import com.qxlh.dao.core.ILeaderDao;
import com.qxlh.dao.core.IUniversityDao;
import com.qxlh.dao.student.IStudentDao;
import com.qxlh.dao.system.IConfigDao;
import com.qxlh.dao.user.IUserDao;
import com.qxlh.model.News.Archive;
import com.qxlh.model.News.News;
import com.qxlh.model.News.NewsCate;
import com.qxlh.model.System.Config;
import com.qxlh.model.core.Leader;
import com.qxlh.model.core.University;
import com.qxlh.model.student.Student;
import com.qxlh.model.user.User;
import com.qxlh.service.News.INewsService;
import com.qxlh.service.common.ILinkService;
import com.qxlh.service.core.IUniversityService;
import com.qxlh.service.system.IConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class testMybatis {
    ArrayList list = new ArrayList();
    @Resource
    IUserDao userDao;
    @Resource
    IStudentDao studentDao;

    @Resource
    INewsDao newsDao;
    @Resource
    IUniversityDao universityDao;

    @Resource
    ILinkDao linkDao;
    @Resource
    ILinkService linkService;

    @Resource
    IArchiveDao archiveDao;
    @Resource
    INewsCateDao newsCateDao;
    @Resource
    IConfigDao configDao;
    @Resource
    ILeaderDao leaderDao;
    @Resource
    IUniversityService universityService;

    @Test
    public void findLeader(){
       //List<University> list = universityService.allList();

    }
    @Test
    public void testConfig(){
        List<Config> allList =configDao.allList();
        int i =1;
    }

    @Test
    public void testUniversity(){
       University university = universityDao.findById(1);
    }

    @Test
    public void testArchiveDao(){
//        Archive archive = new Archive(1,"biaoti2",2,new Date(),"miaoshu","key",1,10,"mahsin",null,new Date(),new Date(),null,1,"zhelishiwenzhangde neirong");
//        archiveDao.save(archive);
//
//        archiveDao.updateViewCount(1);
//        archive.setArchiveId(1);
//        archiveDao.update(archive);
    }

    @Test
    public void testNewCate(){
        System.out.println(System.getProperty("user.dir"));
//
    }



    @Test
    public void teseNewsDao() {
        Page page = new Page(1,5);
        PageHelper.startPage(2, 5);
        List<News> list = newsDao.listByPage(page, 0,null,null,1,2);
        PageInfo<News> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setPageInfo(pageInfo);
        model.setData(list);
    }

    @Test
    public void m2(){
        User user = userDao.findById(2);
        System.out.println(user.toString());
    }


    @Test
    public void m3(){
        Student student = new Student();
        student.setUsername("ma");
        student.setUid(2);
        student.setGender(false);
        student.setEmail("1141313082");
        student.setNumber(11111111);
        student.setCollege(1);
        student.setCollege(1);
        int i = studentDao.save(student);


        System.out.println(i);

    }
}
