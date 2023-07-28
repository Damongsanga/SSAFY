package com.ssafy.ws.step2;

import java.util.ArrayList;

public class MovieManagerImpl implements IMovieManager {
	private final int MAX_SIZE = 100;
	private ArrayList<Movie> movieList = new ArrayList<>();
	private static MovieManagerImpl mv = new MovieManagerImpl();

	private MovieManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public static IMovieManager getInstance() {
		return mv;
	}

	public void add(Movie movie) {
		if (movieList.size() < MAX_SIZE) {
			movieList.add(movie);
		} else {
			System.out.println("더이상 추가할 수 없습니다.");
		}

	}

	public Movie[] getList() {
		if (movieList.size() == 0) {
			System.out.println("길이가 0");
			return null;
		}

		return movieList.toArray(new Movie[0]);
	}

	public Movie[] getMovies() {
		ArrayList<Movie> arraylist = new ArrayList<>();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie) {
				continue;
			}
			arraylist.add(movieList.get(i));
		}

		if (arraylist.size() == 0)
			return null;
		return arraylist.toArray(new Movie[0]);

	}

	public SeriesMovie[] getSeriesMovies() {
		ArrayList<SeriesMovie> arraylist = new ArrayList<>();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie)
				arraylist.add((SeriesMovie) movieList.get(i));
		}

		if (arraylist.size() == 0)
			return null;
		return arraylist.toArray(new SeriesMovie[0]);
	}

	public Movie[] searchByTitle(String title) {
		if (movieList.size() == 0)
			return null;
		ArrayList<Movie> arraylist = new ArrayList<>();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getTitle().contains(title))
				arraylist.add(movieList.get(i));
		}

		if (arraylist.size() == 0)
			return null;
		return arraylist.toArray(new Movie[0]);
	}

	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < movieList.size(); i++) {
			sum += movieList.get(i).getRunningTime();
		}
		return movieList.size() == 0 ? 0 : sum / movieList.size();
	}

}