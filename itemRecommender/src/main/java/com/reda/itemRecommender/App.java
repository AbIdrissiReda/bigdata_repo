package com.reda.itemRecommender;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			System.out.println("HI !");
			DataModel dm = new FileDataModel(new File("data/u.csv"));

			ItemSimilarity sim = new LogLikelihoodSimilarity(dm);

			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(
					dm, sim);

			int x = 0;
			for (LongPrimitiveIterator item = dm.getItemIDs(); item.hasNext();) {
				long itemId = item.nextLong();
				List<RecommendedItem> vList = recommender.mostSimilarItems(
						itemId, 5);

				for (RecommendedItem recommendedItem : vList) {
					System.out.println(itemId + ","
							+ recommendedItem.getItemID() + ","
							+ recommendedItem.getValue());
				}
				System.out.println("---------------");
				x++;
				if (x > 10)
					System.exit(1);
			}
		}catch (Exception exp) {

		}
	}
}
