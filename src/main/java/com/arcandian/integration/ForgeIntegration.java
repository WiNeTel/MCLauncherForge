package com.arcandian.integration;

import java.io.File;

import com.kokakiwi.mclauncher.api.LauncherAPI;

public class ForgeIntegration {

	@SuppressWarnings("unused")
	private LauncherAPI api;

	public static void cleanMods(LauncherAPI api) {

		try {

			final String mDir = api.getMinecraftDirectory().toString();
			System.out.println(mDir);
			final File core = new File(mDir + File.separatorChar + "coremods" + File.separatorChar);
			final File mods = new File(mDir + File.separatorChar + "mods" + File.separatorChar);
			final File config = new File(mDir + File.separatorChar + "config" + File.separatorChar);
			final File modpatches = new File(mDir + File.separatorChar + "modpatches" + File.separatorChar);
			final File resources = new File(mDir + File.separatorChar + "resources" + File.separatorChar);

			System.out.println("Installation avec FML detectee, nettoyage des dossiers avant MAJ...");

			if (core.exists()) {

				
				core.delete();
				System.out.println("Suppression de coremods...");

			}

			if (mods.exists()) {

				deleteFilesInDirectory(mods.getAbsolutePath().toString());
				mods.delete();
				System.out.println("Suppression de mods...");
					
			}
			else {
				System.out.println("Dossier mods inexistant !");
			}

			if (config.exists()) {

				deleteFilesInDirectory(config.getAbsolutePath().toString());
				config.delete();
				System.out.println("Suppression de config...");

			}
			else {
				System.out.println("Dossier config inexistant !");
			}

			if (modpatches.exists()) {

				deleteFilesInDirectory(modpatches.getAbsolutePath().toString());
				modpatches.delete();
				System.out.println("Suppression de modpatches...");

			}
			else {
				System.out.println("Dossier modpatches inexistant !");
			}
			
			if (resources.exists()) {

				deleteFilesInDirectory(resources.getAbsolutePath().toString());
				resources.delete();
				System.out.println("Suppression de resources...");

			}
			else {
				System.out.println("Dossier resources inexistant !");
			}

			System.out.println("Suppression effectuee avec succes, lancement...");

		} catch (final Exception e) {
			System.out.println("Echec de la suppression...");
			e.printStackTrace();
		}

	}

	static private void deleteFilesInDirectory( String emplacement )
	{
	  File path = new File( emplacement );
	  String sep = File.separator.toString();
	  if( path.exists() )
	  {
	    File[] files = path.listFiles();
	    for( int i = 0 ; i < files.length ; i++ )
	    {
	      if( files[ i ].isDirectory() )
	      {
	        deleteFilesInDirectory( path+sep+files[ i ] );
	        
	      }
	      files[ i ].delete();
	      System.out.println("Supression du fichier : " + files[ i ].getName().toString());
	    }
	  }
	}
	
}
