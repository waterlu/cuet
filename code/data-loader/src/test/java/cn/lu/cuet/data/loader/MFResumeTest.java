package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.entities.*;
import cn.lu.cuet.data.loader.repository.MFResumeRepository;
import cn.lu.cuet.data.loader.service.ResumeService;
import cn.lu.cuet.util.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by mofang on 19/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataLoaderApplication.class)
public class MFResumeTest {
    private Logger logger = LoggerFactory.getLogger(MFResumeTest.class);

    @Autowired
    private MFResumeRepository mfResumeRepository;

    @Test
    public void testAll() throws Exception{
        testCreateResume();
    }

    private void testCreateResume() throws Exception {
        MFResume resume = null;
        MFObjective objective = null;
        MFWorkExp workExp = null;
        MFCompany company = null;
        long id;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int year;
        int month;
        int day;

        // 1
        id = 1;
        resume = new MFResume();
        resume.setAvailable(true);
        year = 1992;
        month = RandomUtil.getRandom(1, 13);
        day = RandomUtil.getRandom(1, 30);
        calendar.set(year, month, day);
        resume.setBirthDate(formatter.format(calendar.getTime()));
        resume.setEducation(Constant.EDUCATION_HIGH_SCHOOL);
        resume.setGender(Constant.GENDER_MALE);
        resume.setId(id);
        resume.setName("李星星");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("软件工程师");
        objective.setCategory("后端开发");
        objective.setCity("北京");
        objective.setSalary(Constant.SALARY_4_6);
        resume.setObjective(objective);
        resume.setUserId(id);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("金科博悦");
        company.setPosition("信息技术专员");
        company.setDesc("java 开发");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("知通网");
        company.setPosition("客户代表");
        company.setDesc("主要从事企事业单位的第三方服务公司，通过各种形式于客户达成合作，为客户提供公司建站，线上销售，企业招投标等服务。");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("北京金融家股份有限公司");
        company.setPosition("市场/营销/拓展总监");
        company.setDesc("负责炒股软件的开发和运用以及市场的推广。这是一个全新的行业，我在这个公司得到金融知识的培训和市场规则。");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("日本大金股份有限公司北京分公司");
        company.setPosition("销售经理");
        company.setDesc("在大金的工作中让我把学到的知识用于实践，在销售岗位走到带队，我用了2个月。");
        workExp.addCompany(company);        
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[" + id + "]=" + resume.toString());

        // 2
        id = 2;
        resume = new MFResume();
        resume.setAvailable(true);
        year = 1989;
        month = RandomUtil.getRandom(1, 13);
        day = RandomUtil.getRandom(1, 30);
        calendar.set(year, month, day);
        resume.setBirthDate(formatter.format(calendar.getTime()));
        resume.setEducation(Constant.EDUCATION_JUNIOR_COLLEGE);
        resume.setGender(Constant.GENDER_MALE);
        resume.setId(id);
        resume.setName("吴川南");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("项目总监 、 it项目经理/主管 、 互联网产品经理/主管 、 运营主管/专员 、 数据运营");
        objective.setCategory("java 、 c++ 、 php");
        objective.setCity("北京-不限");
        objective.setSalary(Constant.SALARY_10_15);
        resume.setObjective(objective);
        resume.setUserId(id);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("成都格志科技有限公司");
        company.setPosition("互联网运营经理/总监/电信业务经理/总监");
        company.setDesc("从2014年4月被朋友邀请合伙创业，成立互联网公司。于4月底前往云南电信洽谈公司的第一个项目，5月底项目成立，在云南电信开展项目、管理现场等；过去的2014年，公司致力于电信运营商、大型企事业互联网渠道、产品的数据化运营，通过软件+咨询+服务的模式，以数据分析为基础，配合丰富的线上运营经验，提升运营商及互联网公司线上（网掌短微app）运营能力，提升产品销售业绩。2015年，公司转型寻找新的互联网机会，与微芥科技合作，开发大型b2b平台――微聚元，于2015年10月上线。至今公司一直致力于互联网方向发展，而我转调至微芥开展互联网平台、产品运营工作。详细如下： 1、在格志参与公司高层会议，制定公司战略方向，落实战略发展政策方针，确保公司平稳运营的同时，寻找新的商业利益；2、在格志配合公司市场拓展，项目洽谈。拓展各省市运营商项目，与各省接口负责人洽谈项目的需求及可行性，根据集团政策向各省提供业务咨询服务，并签订相关的商业合作合同；3、在格志搭建管理各省团队。带领精英团队奔赴各省开展项目，招聘当地人员进入项目组实施项目，培养当地团队的专业技能及综合素质，培养当地项目负责人，后期远程操控项目，现场人员执行；4、在格志实施各省项目。与各省项目负责人及合作公司领导对接（包括商务对接），带领项目执行团队实施项目，围绕项目kpi指标，统筹规划，完成各项运营指标；5、在微芥开展互联网方向的运营，包含产品运营、渠道运营、自媒体运营和平台、app运营等，并且将以往运营商的运营经验与互联网运营相结合，策划从推广、用户引流、用户细分、用户体验、用户购买、数据分析、策略调整等一系列流程；6、在微聚元项目上，制定互联网运营计划，包括线上和线下，收集、分析和总结运营效果；会亲自参与运营数据分析，根据数据分析和用户反馈，制定产品改善策略，优化产品体验及流程；其实在运营商与互联网的运营工作中，互联网运营的概念和原理都基本相通的，因此在工作中，了解行业、产品业务之后，能够很快的针对现在的行业、产品开展运营工作；");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("广州兆达讯息科技有限公司（广州御迅网络技术有限公司）");
        company.setPosition("项目经理/运营经理");
        company.setDesc("公司专业从事移动通讯领域无线增值业务的服务和运营。主要与中国电信合作，从事电信增值业务，流量经营，存量客户的运营支撑工作。工作领域跨电信电子渠道、市场部、企信部、客服部等多个部门。 2012年，在我们团队及电渠的努力下，将四川短厅各项kpi指标（用户数、查询量、业务办理量、缴费量）由集团综合排名第八九名，提升至集团排名第四；2013年，综合排名再次由集团第四提升至第二名，流量经营集团排名第一名。 工作职责及描述：  1、与中国电信电子渠道部门合作，提供高效的驻点支撑工作，建立合作关系，完成各项kpi指标，设计、优化、完善短信营业厅10001；  2、围绕kpi指标，从系统平台的完善、营销活动推广、运营分析多个方面完成kpi指标。协调相关的技术支撑厂家和电信其他部门按照电渠流程，上线、下线、修改产品和业务，并处理产品业务规则等问题；如流量包、增值业务、营销活动的上线开发等；   3、工作中避免不了大大小小的方案汇报，如营销活动方案、效果评估总结、数据分析和解决方案、电子渠道经营分析方案、工作总结和计划方案、年终总结等等，通常都以word、excle、ppt等office办公软件的形式提交；  4、数据分析！熟悉电信系统中大部分重要数据库表的关系，能够自主的在后台提取数据，通过sql数据库处理数据，形成多纬度关系的数据表，对电信业务办理、营销活动进行数据分析，汇报分析结果，并以乙方的立场提出优化、调整等其他运营措施。 5、2013年重点以流量经营为主，分析用户的行为、位置及习惯等纬度，根据整个市场分析电信大网用户数据，并提出相应的运营方案，提升户均流量及流量收入；熟悉运营商行业主要业务的运作模式，对流量经营有深厚的工作经验； 6、熟悉电信miboss系统、crm系统、ismp系统、vsop系统、计费系统、数据系统等系统，并了解各个系统与其他功能性平台的交互；");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("深圳博奥思特企业管理咨询有限公司");
        company.setPosition("调研督导/咨询顾问");
        company.setDesc("公司是企业管理咨询类的民营公司，主要与中国移动合作，从事调研，咨询，营业厅以及片区培训，以达到提升中国移动社会渠道（营业厅）服务质量的工作。 工作职责及描述： 1、从事市场调研，招聘兼职人员或者公司访问员；带领兼职人员或者公司访问员对中国移动社会渠道（营业厅）进行神秘顾客暗访检测。 2、把控暗访项目的时间进度，暗访问卷的质量把关；项目款申报；3、对于营业厅现场驻点辅导，发现营业厅服务方面的问题，现场辅导；集中培训片区营业员，提升中国移动营业厅服务质量。");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("成都无限天地图文设计制作有限公司");
        company.setPosition("业务员");
        company.setDesc("公司主要做商场、超市的dm印刷广告以及画册等印刷业务。 工作职责及描述： 1、联系客户，并到四川省内各个城市（除偏远地区）通过客户拜访的形式，进行业务销售，收集客户资料，以备后期销售公司业务； 2、为客户的商品拍照，然后交由设计师设计； 3、负责公司客户资料的保存及更新，如客户的dm单电子文档等资料的保存； 4、管理公司的考勤、后勤等工作；");
        workExp.addCompany(company);        
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[ + id + ]=" + resume.toString());
        
        // 3
        id = 3;
        resume = new MFResume();
        resume.setAvailable(true);
        year = 1987;
        month = RandomUtil.getRandom(1, 13);
        day = RandomUtil.getRandom(1, 30);
        calendar.set(year, month, day);
        resume.setBirthDate(formatter.format(calendar.getTime()));
        resume.setEducation(Constant.EDUCATION_MASTER);
        resume.setGender(Constant.GENDER_MALE);
        resume.setId(id);
        resume.setName("臧剑超");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("互联网软件开发工程师 、 银行 、 it-管理 、 数据库工程师/管理员 、 贸易/外贸专员/助理");
        objective.setCategory("数据开发 、 风控 、 外贸专员/助理");
        objective.setCity("北京，天津-河东区");
        objective.setSalary(Constant.SALARY_10_15);
        resume.setObjective(objective);
        resume.setUserId(id);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("天津天成金控");
        company.setPosition("软件工程师");
        company.setDesc("ios开发");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("北京钓鱼台国旅");
        company.setPosition("ios开发工程师");
        company.setDesc("负责开发钓鱼台旅游公司的软件。");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("上海缘美技术有限公司");
        company.setPosition("软件工程师");
        company.setDesc("开发美丫的产品。负责框架的整体架构。逻辑的编写。");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("济南普联软件公司");
        company.setPosition("erp技术开发");
        company.setDesc("在公司框架的基础上开发项目，主要以as语言的flex，和java语言来写程序，制作表单，做组件，写插件，以及写些业务逻辑脚本。");
        workExp.addCompany(company);        
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[ + id + ]=" + resume.toString());    
                              
        // 4
        id = 4;
        resume = new MFResume();
        resume.setAvailable(true);
        year = 1988;
        month = RandomUtil.getRandom(1, 13);
        day = RandomUtil.getRandom(1, 30);
        calendar.set(year, month, day);
        resume.setBirthDate(formatter.format(calendar.getTime()));
        resume.setEducation(Constant.EDUCATION_BACHELOR);
        resume.setGender(Constant.GENDER_FEMALE);
        resume.setId(id);
        resume.setName("何碧珠");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("市场/营销 、 广告客户经理 、 文案/策划 、 媒介专员 、 会务/会展专员");
        objective.setCategory("广告制作 、 助理");
        objective.setCity("广东-深圳");
        objective.setSalary(Constant.SALARY_8_10);
        resume.setObjective(objective);
        resume.setUserId(id);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("深圳沃利创意工程展览有限公司");
        company.setPosition("高级商务经理");
        company.setDesc("岗位职责：1、执行公司项目的商务流程；2、负责行业大客户的客户管理、合同执行、应收应付款管理等；3、负责项目招投标及相关商务事宜的实施与配合；4、协调公司内部相关部门的衔接与日常工作配合；5、协调公司与合作伙伴的合作；6、开发客户资源以及维护原有客户关系；7、制定商务小组年度商务方案并设定年度赢利目标；8、主要负责接待重要客户并讲解公司产品实验室；");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("中国平安");
        company.setPosition("客户经理");
        company.setDesc("工作职责1、服务于公司vip客户及高价值个人客户，为高价值个人客户提供全方面金融理财服务；2、通过与客户沟通，了解客户在家庭财务方面存在的问题以及理财方面的需求；3、根据客户的资产规模、生活目标、预期收益目标和风险承受能力进行需求分析，出具专业的理财计划方案，推荐合适的理财产品；4、通过调整存款、股票、债券、基金、保险等各种金融产品的理财产品比重达到资产的合理配置，使客户的资产在安全、稳健的基础上保值升值；5、协助客户开立帐户及一系列后期服务；6、定期与客户联系，报告理财产品的收益情况，向客户介绍新的金融服务、理财产品及金融市场动向，维护良好的信任关系。平安综合金融客户经理，平安的人寿、车险、贷款、信用卡等多种金融业务都属于工作范围。已组建七人小团队成为筹备主任。曾获得以下奖项：2014年2月 获得优才计划“新秀之星”荣誉称号2014年3月 获得优才计划“卓越之星”荣誉称号2014年5月 入围第十四届钻石高峰会“高峰钻石会员”2014年7月 荣获“钻石新星奖”2014年7月 成为群星俱乐部会员2014年8月 荣获第五届人才高峰论坛“铜星奖”2014年10月 获得第二届优才发展峰会深寿优才铸王牌“增员之星”荣誉称号2014年10月 入围中国平安深寿“百强优才”");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("深圳市永之禾影视文化传媒有限公司");
        company.setPosition("公共关系部");
        company.setDesc("工作职责：1-负责项目流程与执行，协助进度监控，撰写会议记录，ppt方案，提案，日常合同处理；2-协助完成部门工并制定相关流程制度；3-通过seo优化，数据分析，竞价排名等提高搜索引擎排名；4-熟悉微博、微信营销、粉丝增加、公共帐号运营；5-负责软文推广，在微博、微信、官网每天进行一到两则公司新闻或者相关干活推送；6-宣传期间负责与各线上媒体（爱奇艺、优酷、迅雷、pps等）资源联系，以便对客户的产品做好线上的推广；7-分析核对数据信息，并对各种销售信息(含数据)进行整理；8-上级助理，负责协助处理日程；");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("天艺唯创国际文化传媒有限公司");
        company.setPosition("项目代表");
        company.setDesc("1-负责来访接待，与客户沟通提案，提炼需求和连接内外部资源，主要负责公共关系维护，跟进工作进度，维护客户与公司良好的合作关系；2-梳理推广目的锁定推广人群，选择适合的推广媒体；3-线上推广活动的策划及软文文案撰写；4-参与集团内的推广策划会议并提出具备建设性思考方向；5-协助总经理处理业务谈判工作；6-在授权范围内协助总经理做好各项汇报、联络工作；");
        workExp.addCompany(company);        
        company = new MFCompany();
        company.setName("深圳市盐田区广播电视台");
        company.setPosition("实习生");
        company.setDesc("1-外出采访；2-撰写新闻稿；3-进行后期剪辑；4-配合新闻播出审核工作");
        workExp.addCompany(company);                
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[ + id + ]=" + resume.toString());


        
    }
}
