package com.arcandian.integration;

import java.io.File;

import com.kokakiwi.mclauncher.api.LauncherAPI;

public class ForgeIntegration {

	public static void cleanMods(LauncherAPI api) {

		final char sep = File.separatorChar;
		final String[] dirs = { "coremods", "mods", "config" };
		final String mDir = api.getMinecraftDirectory().toString();

		try {

			for (String v : dirs) {

				File path = new File(mDir + sep + v);
				
				
				deleteDirectories(path);
				System.out.println("Traitement du dossier " + v);

			}

		} catch (final Exception e) {

			e.printStackTrace();

		}

	}

	static private void deleteDirectories(File file) {
		
		File path = new File(file.getPath());

		if (path.exists()) {

			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {

				if (files[i].isDirectory()) {

					deleteDirectories(files[i]);

				}
				
				files[i].delete();
				System.out.println("Supression du fichier : " + files[i].getName().toString());
			}
		}
	}

}
