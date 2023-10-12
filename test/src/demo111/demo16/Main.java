package demo111.demo16;

import lombok.*;

import java.util.Objects;

public class Main {

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student{
    private String ID;
    private String name;
    private double ScoreEnglish;
    private double ScoreMath;
    private double ScoreComputer;
    private double SUMALLScore;

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", ScoreEnglish=" + ScoreEnglish +
                ", ScoreMath=" + ScoreMath +
                ", ScoreComputer=" + ScoreComputer +
                ", SUMALLScore=" + SUMALLScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.ScoreEnglish, ScoreEnglish) == 0 && Double.compare(student.ScoreMath, ScoreMath) == 0 && Double.compare(student.ScoreComputer, ScoreComputer) == 0 && Double.compare(student.SUMALLScore, SUMALLScore) == 0 && Objects.equals(ID, student.ID) && Objects.equals(name, student.name);
    }

    public double sum(){
        return ScoreMath+ScoreEnglish+ScoreComputer;
    }


    public int compare(Student student){
        double compare=this.SUMALLScore-student.getSUMALLScore();
        if (compare>0){
            return 1;
        }
        else if(compare==0){
            return 0;
        }
        else{
            return -1;
        }
    }
}
