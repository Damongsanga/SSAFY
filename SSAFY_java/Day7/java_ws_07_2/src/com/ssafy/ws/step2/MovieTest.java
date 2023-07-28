package com.ssafy.ws.step2;



public class MovieTest {
	public static void main(String[] args) {
		
		// 2개의 영화를 생성하고 출력
		Movie movie1 = new Movie(1, "엘리멘탈", "픽사", "애니메이션", 108);
		Movie movie2 = new Movie(2, "어바웃타임", "몰라용", "로맨스코미디", 120);
		SeriesMovie movie3 = new SeriesMovie(3, "해리포터", "워너브라더스", "판타지", 200, 1, "마법사의 돌");
		SeriesMovie movie4 = new SeriesMovie(4, "해리포터", "워너브라더스", "판타지", 180, 2, "비밀의 방");
		SeriesMovie movie5 = new SeriesMovie(5, "해리포터", "워너브라더스", "판타지", 160, 3, "아즈카반의 죄수");
		System.out.println("<toString>");
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println(movie3);
		System.out.println(movie4);
		System.out.println(movie5);
		System.out.println();
		
		// MovieManaer 객체를 생성하여 영화를 앞서 생성한 영화를 등록하여 출력
//		MovieManagerImpl manager = (MovieManagerImpl) MovieManagerImpl.getInstance();
		IMovieManager manager = MovieManagerImpl.getInstance();
		Movie[] movieList = manager.getList();
		manager.add(movie1);
		manager.add(movie2);
		manager.add(movie3);
		manager.add(movie4);
		manager.add(movie5);
		System.out.println("<getTitle>");
		System.out.println(movieList[0].getTitle());
		System.out.println(movieList[1].getTitle());
		System.out.println();
		
		//searchByTitle
		System.out.println("<SearchByTitle>");
		for (Movie movie : manager.searchByTitle("해")) {
			System.out.println(movie);
		}
		System.out.println();
		
		System.out.println("<getMovies>");
		for (Movie movie : manager.getMovies()) {
			System.out.println(movie);
		}
		System.out.println();
		
		System.out.println("<getSeriesMovies>");
		for (SeriesMovie seriesMovie : manager.getSeriesMovies()) {
			System.out.println(seriesMovie);
		}
		System.out.println();

		System.out.println("<getRunningTime>");
		System.out.println(manager.getRunningTimeAvg());
		System.out.println();
		
	}
	
}
