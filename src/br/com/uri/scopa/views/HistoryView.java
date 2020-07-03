package br.com.uri.scopa.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HistoryView {

	public void init() throws IOException {
		this.showHistories();
	}

	private void showHistories() throws IOException {
		File folder = new File("src/br/com/uri/scopa/history");
		for(File archive : folder.listFiles()) {
			System.out.println("-------------------------------------");
			System.out.println(archive.getName());
			BufferedReader archiveReader = new BufferedReader(new FileReader(archive));
			String line;
			while((line = archiveReader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
