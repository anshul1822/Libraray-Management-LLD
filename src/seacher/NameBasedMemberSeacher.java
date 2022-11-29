package seacher;

public class NameBasedMemberSeacher implements MemberSeacher {

    private final String memberName;

    public NameBasedMemberSeacher(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
