package com.efrei;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class GoogleEfreiServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		Entity personne = new Entity("Client");
		personne.setProperty("nom", "Tintin");
		dataStore.put(personne);

		Query query = new Query("Client");
		PreparedQuery pq = dataStore.prepare(query);
		for(Entity e: pq.asIterable()){
			System.out.println("nom client=" + e.getProperty("nom"));
		}
	}
}
