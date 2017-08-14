import com.hc.henghuirong.server.App;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by hu.cong.cong on 2017/6/14.
 */

//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional
public class SolrJTest {
    @Autowired
    SolrClient client;

    @Test
    public void contextLoads() throws Exception{

        SolrQuery q = new SolrQuery("*:*");
        q.setStart(1);//起始行
        q.setRows(80);//一次查多少行
        QueryResponse response= client.query(q);
        SolrDocumentList solrLists = response.getResults();
        int solrListSize=solrLists.size();
        for (int i=0;i<solrListSize;i++){
            SolrDocument document=solrLists.get(i);
            System.out.println("------------------------------------------------------------");
            for (Map.Entry<String, Object> set:document.entrySet()){
                System.out.println(set.getKey()+":"+set.getValue());
            }
        }
    }


}
