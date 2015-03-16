package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goband {

	public static int[][] chessboard;
			
	public void init(int num){
		chessboard = new int[num][num];
	}
	
	public void print(){
		for(int i = 0;i < chessboard.length;i += 1){
			for(int j = 0;j < chessboard[i].length;j += 1){
				System.out.print("＋");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Goband goband = new Goband();
		goband.init(15);
		goband.print();
		System.out.print("请输入坐标(x, y)：");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String coordinate = "";
		while( (coordinate = reader.readLine()) != null ){
			String[] arr = coordinate.split(",");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			for(int i = 0;i < Goband.chessboard.length;i += 1){
				for(int j = 0;j < Goband.chessboard[i].length;j += 1){
					if(i == (x - 1) && j == (y - 1)){
						System.out.print("●");
					}else{
						System.out.print("＋");
					}
				}
				System.out.println();
			}
			System.out.print("请输入坐标(x, y)：");	
		}
	}
}
