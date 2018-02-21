package co.za.tangent.domain;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A security role used by Spring Security.
 */
public class Authority {

    
    public Authority() {
		super();
	}
    
    

	public Authority(String name) {
		super();
		this.name = name;
	}



	public Authority(Object object) {
		
	}



	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authority role = (Authority) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "Authority [name=" + name + "]";
	}

    
}
