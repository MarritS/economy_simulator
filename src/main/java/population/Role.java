package population;

public abstract class Role {
	protected RoleProfile profile; 
	protected final int id;

	protected Role(int id) {
		this.id = id; 
	}
	abstract public void performRole();
}
