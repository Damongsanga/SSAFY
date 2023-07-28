package com.ssafy.ws.step5;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 구현한 내용 1. 로그인/회원가입/종료 2. 게시글 목록, 게시글 작성, 게시글 선택, 로그아웃 3. 게시글 작성 4. 게시글 선택 시
 * 해당 글에 정보 출력하고 게시글 삭제 / 댓글 작성 / 댓글 삭제
 *
 * 제대로 구현하지 못한 내용 1. 새로운 아이디로 회원가입/로그인시 그 아이디로 작성된 글들이 아닌 모든 글들이 나오고 접근
 * 가능해져버립니다. > sc.nextLine으로 구현해볼 것 2. input이 1,2,3등이 아닐 때 무한 루프에 빠지는 경우가 있습니다.
 * 2_1. 특히 한글을 입력했을 때 위와 같은 오류가 많음 try catch문으로 잡으려고 하는데 잘 안잡힙니다..
 *
 * 조금 아쉬운 내용 1. 게시물 삭제시 관련 댓글을 모두 삭제하는 removeArticle 메소드에서 removeComment 메소드를
 * 재사용했는데 commentSize 만큼 전체 탐색을 계속 돌려서 댓글이 많아지면 성능이 떨어질 수도 있을 것 같음 2.
 * while(true) 문 만 사용해서 반복을 돌리게 했는데 다른 방법이 있는지..! 3. 긴 코드를 구현해본 적이 처음이어서 가독성이 매우
 * 떨어지네요..
 */

public class BoardTest {

	public static int randomNumber() {
		return (int) Math.random() * 100;
	}

	public static void boardEnter() {

		IUserManager um = UserManagerImpl.getinstance();
		IArticleManager am = ArticleManagerImpl.getinstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("[게시글 목록]");
			List<Article> myArticleList = am.getArticleList();
			System.out.println("0 공지사항");
			if (myArticleList != null) {
				for (int i = 1; i <= myArticleList.size(); i++) {
					System.out.printf("%d %s %n", i, myArticleList.get(i - 1).getTitle());
				}
			}
			System.out.println("------------------------------");

			System.out.println("[게시글 메뉴]");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시글 선택");
			System.out.println("3. 로그아웃");
			System.out.println("0. 종료");
			System.out.println("------------------------------");

			// 무한루프 어떻게 풀지..?
			sc.nextLine();
			int sel2 = -1;
			try {
				sel2 = sc.nextInt();
			} catch (Exception e) {
				continue;
			}

			if (sel2 == 0) {
				return;
			}
			// 게시물 작성
			else if (sel2 == 1) {
				System.out.println("[게시물 작성]");
				System.out.println("이미지 게시물 작성여부 (맞으면 1 아니면 0 입력, 이외 입력시 텍스트 게시물로 작성됩니다.) : ");

				sc.nextLine(); // 이게 왜 필요하지;;;
				int isitimage = sc.nextInt();
				sc.nextLine();
				System.out.println("제목 :");
				String title = sc.nextLine();
				System.out.println("내용 :");
				String content = sc.nextLine();
				System.out.println("------------------------------");
				try {
					int articleId = (int) (Math.random() * 1000);
					if (isitimage == 1) {
						System.out.println("이미지 이름 :");
						String imageTitle = sc.nextLine();
						System.out.println("크기 (width height을 띄어쓰기로 구분하여 입력해주세요):");
						String tmpsize = sc.nextLine();
						System.out.println(tmpsize);
						int width = Integer.parseInt(tmpsize.split(" ")[0]);
						int height = Integer.parseInt(tmpsize.split(" ")[1]);
						am.addArticle(
								new ImageArticle(articleId, title, content, um.getLoginUser().getUserSeq(), 0, new Date(), imageTitle, width, height));
						myArticleList = am.getArticleList();
						System.out.printf("[%d번] [%s] 이미지 게시글이 추가되었습니다. %n", myArticleList.size(), title);
					} else {
						am.addArticle(
								new Article(articleId, title, content, um.getLoginUser().getUserSeq(), 0, new Date()));
						myArticleList = am.getArticleList();
						System.out.printf("[%d번] [%s] 텍스트 게시글이 추가되었습니다. %n", myArticleList.size(), title);
					}
				} catch (ArticleIdDuplicateException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (Exception ee) {
					ee.printStackTrace();
					System.out.println("입력 등에서 에러가 발생하였습니다.");
				}
			}
			// 게시물 선택창
			else if (sel2 == 2) {
				System.out.println("게시글 선택 : ");
				int sel2_2 = -1;

				try {
					sel2_2 = sc.nextInt();
				} catch (Exception e) {
					continue;
				}

				if (sel2_2 == 0) {
					System.out.println("공지사항입니다. \n멋진 개발자가 되어 싸탈하시길 바랍니다. 이상!");
					System.out.println("------------------------------");
					continue;
				}

				Article sel2_2_article;
				try {
					sel2_2_article = am.getArticle(myArticleList.get(sel2_2 - 1).getArticleId());
				} catch (Exception e) {
					sel2_2_article = null;
				}

				if (sel2_2_article != null) {
					System.out.println("------------------------------");
					System.out.println("제목 : " + sel2_2_article.getTitle());
					System.out.println("작성자 : " + um.getUser(sel2_2_article.getUserSeq()).getUserName());
					System.out.println("조회수 : " + sel2_2_article.getViewCnt());
					System.out.println("작성일 : " + sel2_2_article.getReqDate());
					System.out.println("내용 : " + sel2_2_article.getContent());
					System.out.println("------------------------------");
					List<Comment> sel2_2_commentList = am.getCommentList(sel2_2_article.getArticleId());
					try {
						System.out.println("총 댓글의 수 : " + sel2_2_commentList.size());
						for (int i = 0; i < sel2_2_commentList.size(); i++) {
							String content_tmp = sel2_2_commentList.get(i).getContent();
							String content_name = um.getUser(sel2_2_commentList.get(i).getUserSeq()).getUserName();
							System.out.printf("%d. %s 작성자 : %s %n", i, content_tmp, content_name);
						}
					} catch (Exception e) {
						System.out.println("총 댓글의 수 : 0");
					}


					// 게시물 검색 후 게시글 삭제/댓글 작성/댓글삭제기능
					sel2_2_article.setViewCnt(sel2_2_article.getViewCnt() + 1);
					System.out.println("------------------------------");

					System.out.println("1. 게시글 삭제");
					System.out.println("2. 댓글 작성");
					System.out.println("3. 댓글 삭제");
					System.out.println("0. 종료");
					System.out.println("------------------------------");
					int sel3 = sc.nextInt();
					switch (sel3) {
					case (0): // 종료하여 outerMain으로 이동
						return;
					case (1): // 게시물 삭제
						try {
							am.removeArticle(sel2_2_article.getArticleId());
							System.out.println(sel2_2 + "번 게시물을 삭제하였습니다.");
							System.out.println("------------------------------");
						} catch (ArticleNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;

					case (2): // 댓글 작성
						System.out.println("댓글 작성 : ");
						String content_tmp = sc.next();
						am.addComment(new Comment((int) (Math.random() * 1000), sel2_2_article.getArticleId(),
								um.getLoginUser().getUserSeq(), content_tmp, new Date()));
						System.out.println("댓글 작성되었습니다.");
						System.out.println("------------------------------");
						break;

					case (3): // 댓글 삭제
						sel2_2_commentList = am.getCommentList(sel2_2_article.getArticleId()); // 다시 가져와야하나?
						if (sel2_2_commentList == null) {
							System.out.println("삭제할 댓글이 존재하지 않습니다");
						} else {
							System.out.println("삭제할 댓글 번호를 입력해주세요 : ");
							while (sc.hasNext()) {
								int sel2_2_3 = sc.nextInt();
								if (sel2_2_3 < sel2_2_commentList.size()) {
									try {
										am.removeComment(sel2_2_article.getArticleId(),
												sel2_2_commentList.get(sel2_2_3).getCommentId());
									} catch (CommentNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
									}
									break;
								} else {
									System.out.println("댓글 번호를 초과하였습니다.");
									break;
								}
							}

						}
						System.out.println("------------------------------");
						break;
					}

				} else {
					System.out.println("해당 게시물은 존재하지 않습니다.");
					System.out.println("------------------------------");
				}
			} else if (sel2 == 3) {
				um.logout();
				System.out.println("로그아웃합니다");
				System.out.println("------------------------------");
				return;
			}

			// 종료
			else if (sel2 == 0) {
				return;
				// 이걸 어떻게 구현하지??
			}
		}
	}

	public static void articleInfo(int articleNo) {

		IUserManager um = UserManagerImpl.getinstance();
		IArticleManager am = ArticleManagerImpl.getinstance();
		Scanner sc = new Scanner(System.in);

		List<Article> textArticleList;
		List<ImageArticle> imageArticleList;

		if (articleNo == 3) {
			System.out.println("[검색 옵션]");
			System.out.println("1. 제목 검색");
			System.out.println("2. 내용 검색");
			System.out.println("3. 작성자 검색");
			int sel3 = 1;
			try {
				sel3 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("입력타입을 확인하세요 default 값인 제목으로 검색합니다.");
			}
			System.out.println(sel3 == 1 ? "제목 입력" : sel3 == 2 ? "내용 검색" : "작성자 검색");
			sc.nextLine(); // 이게 왜 필요하지;;;
			String sel3_str = sc.nextLine();

			List<Article> sel3_searchArticleList = am.search(sel3, sel3_str);

			if (sel3_searchArticleList == null) {
				System.out.println("게시물이 없습니다.");

			}

			else {
				for (Article article : sel3_searchArticleList) {
					if (article instanceof ImageArticle)
						System.out.println("이미지 게시글 : " + article.getTitle());
					else
						System.out.println("텍스트 게시글 : " + article.getTitle());
				}

			}
			System.out.println("------------------------------");
			return;
		}

		else if (articleNo == 4) {
			System.out.println("[일반 게시글 모아보기]");
			textArticleList = am.getTextArticleList();
			System.out.println("공지사항");
			if (textArticleList == null) {
				System.out.println("------------------------------");
				return;
			}
			for (Article article : textArticleList) {
				System.out.println(article.getTitle());
			}
			System.out.println("------------------------------");
			return;
		}

		else if (articleNo == 5) {
			System.out.println("[이미지 게시글 모아보기]");
			imageArticleList = am.getImageArticleList();
			if (imageArticleList == null) {
				System.out.println("게시물이 없습니다.");
				System.out.println("------------------------------");
				return;
			}

			for (ImageArticle imagearticle : imageArticleList) {
				System.out.println(imagearticle.getTitle());
			}
			System.out.println();
			System.out.println("전체 이미지의 평균크기 : " + am.getImageSizeAvg());

			System.out.println("------------------------------");
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		String userName;
		String nickName;
		String email;
		int userSeq;
		String userId;
		String password;
		int articleId, viewCnt;
		String title, content;

		IUserManager um = UserManagerImpl.getinstance();
		IArticleManager am = ArticleManagerImpl.getinstance();

		List<Article> sel2_2_articleList;
		List<Article> sel3_articleList;
		List<Article> textArticleList;
		List<ImageArticle> imageArticleList;

		System.out.println("------------------------------");

		outerMain: do {

			// 로그인창
			System.out.println("게시판 접속");
			System.out.println("------------------------------");
			System.out.println("작업을 선택하세요.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 검색");
			System.out.println("4. 일반 게시글 모아보기");
			System.out.println("5. 이미지 게시글 모아보기");
			System.out.println("0. 종료");
			System.out.println("------------------------------");

			// 0,1,2가 아니면 다시 선택하도록
			sel = -1;
			try {
				sel = sc.nextInt();
			} catch (Exception e) {
				sel = 0;
				continue;
			}

			// 1. 로그인
			if (sel == 1) {
				login: while (true) {
					System.out.println("[로그인]");
					System.out.println("ID 입력");
					userId = sc.next();
					if (userId.equals("0")) {
						break outerMain;
					}
					System.out.println("PW 입력");
					password = sc.next();
					System.out.println("------------------------------");
					try {
						um.login(userId, password);
						System.out.println("로그인 성공");
						System.out.printf("%s님 환영합니다.%n", um.getLoginUser().getUserName());
						System.out.println("------------------------------");
						break;
					} catch (LoginException e) {
						System.out.println(e.getMessage());
						continue outerMain;
					}

				}

			}
			// 2. 회원가입
			else if (sel == 2) {
				System.out.println("[회원가입]");
				System.out.println("ID 입력 :");
				userId = sc.next();
				System.out.println("PW 입력");
				password = sc.next();
				System.out.println("이름 입력");
				userName = sc.next();
				System.out.println("닉네임 입력");
				nickName = sc.next();
				System.out.println("이메일 입력");
				email = sc.next();
				System.out.println("------------------------------");
				userSeq = (int) (Math.random() * 100);
				try {
					um.signup(new User(userId, password, userName, nickName, email, userSeq));
					System.out.println("회원가입 성공");
					um.login(userId, password);
					System.out.printf("%s님 환영합니다. 자동으로 로그인되었습니다. %n", um.getLoginUser().getUserName());
					System.out.println("------------------------------");
				} catch (UserIdDuplicateException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					System.out.println("같은 ");
				} catch (LoginException l) {
				}

			}
			// 0,1,2 아닌 숫자 입력시 다시 입력하게 함

			else if (sel == 3 || sel == 4 || sel == 5) {
				articleInfo(sel);
				continue outerMain;
			}

			else
				continue outerMain;

			boardEnter();

		} while (sel != 0);

		System.out.println("종료됩니다! 안녕!");
		System.out.println("------------------------------");

	}

}
