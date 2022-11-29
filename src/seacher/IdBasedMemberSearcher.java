package seacher;

public class IdBasedMemberSearcher implements MemberSeacher{

    public final int id;

    public IdBasedMemberSearcher(int id) {
        this.id = id;
    }

    @Override
    public List<Member> search(){
        return null;
    }
}
