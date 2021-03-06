package cral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    public static final long AN_ID = 1L;
    @Autowired
    private MyDao myDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            MyEntity myEntity = new MyEntity();
            myEntity.setId(AN_ID);
            myEntity.setTest("aValue");
            myEntity.setMyEnum(MyEnum._001);
            myDao.save(myEntity);
            MyEntity persistedEntity = myDao.find(AN_ID);
            System.out.println("Persisted entity: " + persistedEntity);
        };
    }

    public enum MyEnum {
        _001("001");
        private String value;

        MyEnum(String value) {
            this.value = value;
        }

        public static MyEnum fromValue(String value) {
            for (MyEnum myEnum : MyEnum.values()) {
                if (myEnum.getValue().equals(value)) {
                    return myEnum;
                }
            }
            throw new IllegalArgumentException();
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }


    }

}
