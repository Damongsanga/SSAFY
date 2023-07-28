package com.ssafy.ws.step2;

import java.util.ArrayList;

public class MovieManagerImpl implements IMovieManager {
	private int size = 0;
	private final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private static MovieManagerImpl mv = new MovieManagerImpl();

	private MovieManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IMovieManager getInstance() {
		return mv;
	}

	public void add(Movie movie) {
		movieList[size++] = movie;
	}

	public Movie[] getList() {
		return movieList;
	}

	public Movie[] getMovies() {
		if (size == 0)
			return null;
		ArrayList<Movie> movieArraylist = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				continue;
			}
			movieArraylist.add(movieList[i]);
		}
		Movie[] returnlist = new Movie[movieArraylist.size()];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = movieArraylist.get(i);
		}
		return returnlist;
	}

	public SeriesMovie[] getSeriesMovies() {
		if (size == 0)
			return null;
		ArrayList<Movie> movieArraylist = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) 
			movieArraylist.add(movieList[i]);
		}
		SeriesMovie[] returnlist = new SeriesMovie[movieArraylist.size()];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = (SeriesMovie) movieArraylist.get(i);
		}
		return returnlist;
	}

	public Movie[] searchByTitle(String title) {
		if (size == 0)
			return null;
		ArrayList<Movie> movieArraylist = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title))
				movieArraylist.add(movieList[i]);
		}
		Movie[] returnlist = new Movie[movieArraylist.size()];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = movieArraylist.get(i);
		}
		return returnlist;
	}
	
	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return size == 0? 0 : sum/size;
	}


}
