package kr.or.connect.mavenweb.dto;

public class Category {
    private Integer id;
    private String name;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{"+
                "id="+id+
                ", name='"+name+'\''+
                ", count="+count+
                '}';
    }
}
