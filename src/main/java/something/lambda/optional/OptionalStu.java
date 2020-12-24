package something.lambda.optional;

import java.util.Optional;

/**
 * java8 Optional 解决null
 */
public class OptionalStu {

    public static void main(String[] args) {
        /*--构造的两种方法--*/
        Optional<String> opt =  Optional.empty();

        Class_ class_ = new Class_();
        Optional<Class_> a = Optional.ofNullable(class_);
        /*--构造结束--*/
        opt.orElse("2");

        //消费者
        a.ifPresent((e) -> System.out.println(e.getStu()));
        //生产者
        a.orElseGet(()-> new Class_());
        //类似于替换操作  和 filter有点像 只是filter添加自己的逻辑判断
        a.orElse(new Class_());
        //抛出异常
        a.orElseThrow(() -> new RuntimeException("shibai"));
        //boolean
        a.filter((e) -> {
            if (e.getStu() == null) {
                return true;
            }
            return false;
        });
        //基本本身产生新的optional
        a.map((e) -> e.getStu());

        //判断class不为null,并且student也不为null,student下的num也不为null
        Optional.ofNullable(class_)
                .map(classes ->classes.getStu())
                .map(student -> student.getNum())
                .orElseThrow(() ->new RuntimeException(""));

    }


}

class Class_ {

    private Student stu = new Student();

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
}

class Student {

    private String num = "2";

    public String getNum() {
        return num;
    }
}


