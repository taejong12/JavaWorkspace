package collectionFrameworkPrac;


	public class Member implements Comparable<Member> {
		Integer memberId;
		String name;
		Integer age;

		Member(int id, String name, int age) {
			this.memberId = id;
			this.name = name;
			this.age = age;
		}

		//이름은 중복될 가능성이 있고 나이도 중복될 가능성이 있다 하지만 id는 중복될 가능성이 없다.
		//원시형이 wrapper 언박싱
		
		@Override
		public int hashCode() {
			return memberId.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Member) {
				Member mem = (Member)obj;
				return mem.memberId==memberId;
			} else {
				return false;
			}
			
		}
		//Member 변수와 새로운 변수를 비교
		//3개를 동시에 비교는 불가
		//3개 중에 하나를 골라서 비교, 비교 대상 초이스
		//비교하는 해당 대상이 크면 양수 작으면 음수 같으면 0 
		//compareTo로 비교하는데 비교하는 해당 대상이 크면 양수 작으면 음수 같으면 0
		//내가 크면 양수 작으면 음수 같으면 0
		@Override
		public int compareTo(Member mem) {
			// -1(음수)을 곱하면 음수가 양수가 되고 양수가 음수가 되면서 대소 비교를 반대로 하면서 역순으로 바뀐다
			return (this.memberId.compareTo(mem.getMemberId()))*(-1);
//			return (this.name.compareTo(mem.getName()));
//			return (this.age.compareTo(mem.getAge()));
		}

		public Integer getMemberId() {
			return memberId;
		}

		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		
	}

