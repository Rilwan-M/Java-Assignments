import java.util.Scanner;

public class QuestionService {


    Question[] questions = new Question[3];

    public QuestionService(){
        questions[0] = new Question(1,"What is programming lang?","english","Java","Tamil","Sinhala","Java");
        questions[1] = new Question(2,"What is programming lang?","english","Java","Tamil","Sinhala","Java");
        questions[2] = new Question(3,"What is programming lang?","english","Java","Tamil","Sinhala","Java");

    }

    public int displayQuestionsAndResults() {

        int i =0, results=0;
        String[] answers = new String[3];
        for(Question q : questions){
            System.out.println((i+1)+". "+q.getQuestion());
            System.out.println("a. "+q.getOpt1());
            System.out.println("b. "+q.getOpt2());
            System.out.println("c. "+q.getOpt3());
            System.out.println("d. "+q.getOpt4());
            System.out.println();
            Scanner sc = new Scanner(System.in);

            answers[i] = sc.nextLine();
            System.out.println();

            i++;
        
        }

        for(int j=0;j<3;j++){

            if (answers[j].equalsIgnoreCase(questions[j].getAnswer()))
                results++;

        }


        return results;

            

    }
    
}
