import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class Main {
	
	public static void main(String[] args) {
        Client client = null;
        try {
//          my-application
            Builder settings = Settings.builder().put("cluster.name", "dw-Elasticsearch");
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("54.183.91.231"), 9301));
//          String json = "{" +
//                  "\"user\":\"kimchy\"," +
//                  "\"postDate\":\"2013-01-30\"," +
//                  "\"message\":\"trying out Elasticsearch\"" +
//              "}";
//
//          IndexResponse response = client.prepareIndex("twitter", "tweet")
//                  .setSource(json)
//                  .get();
             
            IndicesExistsResponse indexResponse = client.admin().indices().prepareExists("dwnews")
                    .execute().actionGet();
            System.out.println(indexResponse.isExists());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            client.close();
        }
         
         
    }
	
}
