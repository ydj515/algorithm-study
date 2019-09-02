package num17365;

public class Main {

	public static void main(String[] args) {
		// 자료구조에 저장할 데이터
		String data[] = new String[] { "abcd", "abcf", "bcd", "a", "bcdefg", "defg", "aac", "baz", "foo", "foobar",
				"자바" };

		Trie matcher = new Trie();

		for (int i = 0; i < data.length; i++) {
			// 배열에 있는 데이터를 trie 자료구조에 저장
			matcher.insert(data[i]);
		}

		// trie에 있는 데이터 콘솔에 나열.
		matcher.printWord();

		System.out.println("=======제거========");
		System.out.println("[abcd,abc,a] 제거");
		matcher.remove("abcd");
		matcher.remove("abc");
		matcher.remove("a");

		System.out.println("===================");

		matcher.printWord();

		System.out.println("=======검색========");

		for (int i = 0; i < data.length; i++) {
			System.out.println("\tsearch test[" + data[i] + "]:" + matcher.search(data[i]));
		}
	}

}