package org.springframework.samples.mvc.recommend;


import org.apache.mahout.cf.taste.vjianke.engine.ContentBasedRecommender;
import org.apache.mahout.cf.taste.vjianke.engine.SuggestedClipEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liuivan
 * Date: 13-3-18
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RecommendController {
    String developIndexPath = "/Users/liuivan/" +
            "Workspace/Libraries/mahout-distribution-0.7/examples/target/index";

    @RequestMapping("/recommend")
    public @ResponseBody String recommend(){
        ContentBasedRecommender contentBasedRecommender
                = new ContentBasedRecommender();
        Map<String,Double> terms = new Hashtable<String, Double>();
        List<SuggestedClipEntity> suggestedClipEntities =
                new ArrayList<SuggestedClipEntity>();
        contentBasedRecommender.recommendByTerms(
                terms,"",suggestedClipEntities,developIndexPath);
        for(SuggestedClipEntity clipEntity:suggestedClipEntities){
            String suggested = clipEntity.getPartitionKey();
        }

        return "done";
    }
}
