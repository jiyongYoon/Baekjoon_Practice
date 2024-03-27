import java.io.*;
import java.util.*;

public class Main {

	private static class Size {
		int height;
		int weight;
		int order; // 입력 순서
		int rank;

		public Size(int height, int weight, int order) {
			this.height = height;
			this.weight = weight;
			this.order = order;
		}

		public int getHeight() {
			return this.height;
		}

		public int getWeight() {
			return this.weight;
		}

		public int getOrder() {
			return order;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "(" + getHeight() + ", " + getWeight() + " [" + getRank() + "])";
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		ArrayList<Size> arr = new ArrayList<Size>();

		for (int i = 0; i < N; i++) {
			arr.add(new Size(in.nextInt(), in.nextInt(), i));
		}

		Comparator<Size> sizeComparator = new Comparator<Size>() {
			@Override
			public int compare(Size o1, Size o2) {
				if ((o1.getHeight() > o2.getHeight() && o1.getWeight() > o2.getWeight())) {
					return -1;
				} else if ((o1.getHeight() < o2.getHeight() && o1.getWeight() < o2.getWeight())) {
					return 1;
				}
				return 0;
			}
		};

		for (Size size : arr) {
			int count = 1;
			for (Size size2 : arr) {
				if (sizeComparator.compare(size, size2) == 1) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
	}

}