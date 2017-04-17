package com.json.main;

import java.io.IOException;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ConvertToJSON {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();
		JSONObject jsonParentObject = new JSONObject();

		for (Element table : doc.select("table")) {
			for (Element row : table.select("tr")) {
				Elements tds = row.select("td");

				if (!tds.isEmpty()) {
					for (Element td : tds) {
						String name = td.text();
						jsonParentObject.put(name, name);
					}
				}
			}
		}

		System.out.println(jsonParentObject.toString());

	}

}
