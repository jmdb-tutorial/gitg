package jmdbtutorial.gitg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Http {
	public static Response GET(String url) {
		try {
			System.out.println("GET " + url + " HTTP/1.1");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			HttpResponse response = client.execute(request);

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			int statusCode = response.getStatusLine().getStatusCode();
			String reasonPhrase = response.getStatusLine().getReasonPhrase();
			String content = result.toString();

			System.out.println("HTTP/1.1 " + statusCode + " " + reasonPhrase);

			if (response.getEntity().getContentType().getValue().contains("application/json")) {
				System.out.println(prettyPrintJson(content));
			} else {
				System.out.println(content);
			}

			return new Response(statusCode,
					reasonPhrase,
					content,
					response);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String prettyPrintJson(String content) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Object json = mapper.readValue(content, Object.class);

			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

			return indented;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static class Response {
		public final int statusCode;
		public final String statusText;
		public final String content;
		public final HttpResponse original;

		public Response(int statusCode, String statusText, String content, HttpResponse original) {
			this.statusCode = statusCode;
			this.statusText = statusText;
			this.content = content;
			this.original = original;
		}
	}

	public static Response POST(String url, String body) {
		try {
			
			System.out.println("POST " + url + " HTTP/1.1");
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
			request.setEntity(new StringEntity(body));
			HttpResponse response = client.execute(request);

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			int statusCode = response.getStatusLine().getStatusCode();
			String reasonPhrase = response.getStatusLine().getReasonPhrase();
			String content = result.toString();

			System.out.println("HTTP/1.1 " + statusCode + " " + reasonPhrase);

			if (response.getEntity().getContentType().getValue().contains("application/json")) {
				System.out.println(prettyPrintJson(content));
			} else {
				System.out.println(content);
			}

			return new Response(statusCode,
					reasonPhrase,
					content,
					response);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
