package gamelevel;

public class MainBoard {

	public static void main(String[] args) {
		//플레이어 객체 생성
		Player player = new Player();
		player.play(1);
		//play 메소드 호출 레벨 변경 후 다시 play 호출
		player.upgradeLevel();
		player.play(2);
		player.upgradeLevel();
		player.play(3);
		
		
	}

}
