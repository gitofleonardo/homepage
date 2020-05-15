package cn.huangchengxi.homepage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Danmu {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    public Danmu(){

    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
