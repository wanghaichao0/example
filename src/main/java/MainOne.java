import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * @Title: MainOne.java
 * @Package Main
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * 
 * @author 王海超
 * @date 2016年11月30日上午10:36:15
 * @version V1.0
 */
public class MainOne {
	
	public static void main(String[] args) {
        Client client = null;
        try {
        	System.out.println("-------Main-------");
//          my-application
            Builder settings = Settings.builder().put("cluster.name", "dw-Elasticsearch");
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.31.25.79"), 9301));
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
