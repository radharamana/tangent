package co.za.tangent.domain;

import co.za.tangent.domain.enums.FilterEnum;

public class Position implements FilterEnum
{
    private Long id;

    private String sort;

    private String level;

    private String name;

    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public String getSort ()
    {
        return sort;
    }

    public void setSort (String sort)
    {
        this.sort = sort;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    
    
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", sort = "+sort+", level = "+level+", name = "+name+"]";
    }

	@Override
	public String getValue() {
		return id.toString();
	}

	@Override
	public String getLabel() {
		return name;
	}
    
    
}