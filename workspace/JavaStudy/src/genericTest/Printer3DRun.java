package genericTest;

//인터페이스
interface Material{
	//추상메소드
	public abstract void doPrinting();
}
//일반클래스-인터페이스 material 구현
class Powder implements Material{
	//오버라이딩
	@Override
	public String toString() {
		return "사용물질: 파우더";
	}
	//추상메소드 오버라이딩
	@Override
	public void doPrinting() {
		System.out.println("파우더 제품 제작중...");
		
	}
}
class Plastic implements Material {
	//오버라이딩
	@Override
	public String toString() {
		return "사용물질: 플라스틱";
	}
		//추상메소드 오버라이딩
		@Override
		public void doPrinting() {
			System.out.println("플라스틱 제품 제작중...");
			
		}
}
//제너릭 클래스 material 구현된 객체만 받음
class Print3D<T extends Material>{
	//필드
	private T material;
	//getter setter
	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return material.toString();
	}
	public void printing() {
		material.doPrinting();
	}
}

public class Printer3DRun {

	public static void main(String[] args) {
		Print3D<Powder> pPo = new Print3D<>();
		pPo.setMaterial(new Powder());
		Powder pow = pPo.getMaterial();
		System.out.println(pPo);
		pPo.printing();
		
		Print3D<Plastic> pP1 = new Print3D<>();
		pP1.setMaterial(new Plastic());
		Plastic pla = pP1.getMaterial();
		System.out.println(pP1);
		pP1.printing();
	
		Print3D<Material> pMa = new Print3D<>();
		
		pMa.setMaterial(new Plastic());
		System.out.println(pMa);
		pMa.printing();
		
		pMa.setMaterial(new Powder());
		pMa.printing();
		System.out.println(pMa);
	}

}

