package com.revature.app;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;
//import static org.eclipse.jetty.http.HttpStatus;

//import java.sql.SQLException;
import java.util.Set;

import com.revature.beans.ComputerGame;
import com.revature.services.ComputerGameServiceImplementation;

public class projectApp {
	private static ComputerGameServiceImplementation gameServ = new ComputerGameServiceImplementation();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Javalin app = Javalin.create();
		app.start();
		
		app.routes(() -> {
			path("/", () -> {
				get(ctx -> {
					String[] note = {"WELCOME TO MY PROJECT-0","By: Carlo Del Mundo"};
					ctx.json(note);
				});
			
				path("/games", () -> {
					get(ctx -> {
						Set<ComputerGame> games = gameServ.getAll();
						ctx.json(games);
					});
					
					post(ctx -> {
						try {
							ComputerGame game = new ComputerGame();
							game.setGame_name(ctx.queryParam("game_name"));
							game.setDescription(ctx.queryParam("description"));
							game.setGenre(ctx.queryParam("genre"));
							game.setPlayers(ctx.queryParam("players"));
							game.setConsole(ctx.queryParam("console"));
							game.setStatus(ctx.queryParam("status"));
							
							int id = gameServ.create(game);
							String url = "/games/" + id;
							
							if(id>0) {
								ctx.redirect("/games/" + id);
							} else {
								url = "Save Failed...";
								ctx.json(url);
							}
						} catch (Exception e) {
//							e.printStackTrace();
							String msg = e.getMessage();
							ctx.status(406);
							ctx.json(msg);
						}
					});
					
					path("/{id}", () -> {
						get(ctx -> {
							try {
								int id = Integer.parseInt(ctx.pathParam("id"));
								ComputerGame game = gameServ.getByID(id);
								ctx.json(game);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						});
						put(ctx -> {
							try {
								int id = Integer.parseInt(ctx.pathParam("id"));
								ComputerGame game = gameServ.getByID(id);
								
								game.setGame_name(ctx.queryParam("game_name"));
								game.setDescription(ctx.queryParam("description"));
								game.setGenre(ctx.queryParam("genre"));
								game.setPlayers(ctx.queryParam("players"));
								game.setConsole(ctx.queryParam("console"));
								game.setStatus(ctx.queryParam("status"));
								
								String url = "/games/" + id;
								boolean isUpdated = gameServ.update(game);
								if(isUpdated) {
									ctx.redirect(url);
								} else {
									url = "Update Failed...";
									ctx.json(url);
								}
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						});
					});
					
				});
				path("/search", () -> {
					get(ctx -> {
						try {
							String keyWord = ctx.queryParam("keyWord");
							Set<ComputerGame> games = gameServ.search(keyWord);
							
							ctx.json(games);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				});
			});
		});
		
	}

}
