package edu.hm.trk.modularbeit;

import edu.hm.trk.modularbeit.model.Answer;
import edu.hm.trk.modularbeit.model.Question;
import edu.hm.trk.modularbeit.repository.QuestionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


/**
 * Der Hauptcontroller, welcher die Routen koordiniert.
 *
 */

@Controller
public class HomeController {

    private QuestionRespository qrep;

    @Autowired
    public HomeController(QuestionRespository qrep){
        this.qrep=qrep;
    }


    /**
     * Es wird die Hauptübersicht erstellt und die Fragen werden sortiert
     *
     * @param model
     * @return
     */

    @GetMapping("/")
    public String index(Model model){

        ArrayList<Question> listToSort= new ArrayList<>();
        Iterable<Question> questList=qrep.findAll();


        for(Question q1: questList){
            listToSort.add(q1);
        }

        boolean run=true;
        Question smaller;
        Question bigger;

        // Bubble Sort Algorithmus. Dieser sortiert die einzelen Fragen in abhängigkeit des Richtigkeits Counters
        for(int i=0; i< listToSort.size() && run==true; i++ ){
            run= false;

            for(int y=0; y < listToSort.size()-1;y++){
                if(listToSort.get(y).getRightCounter() > listToSort.get(y+1).getRightCounter()){
                    bigger= listToSort.get(y);
                    smaller= listToSort.get(y+1);
                    listToSort.set(y,smaller);
                    listToSort.set(y+1,bigger);
                    run=true;
                }
            }
        }

        Collections.reverse(listToSort);
        System.out.println();


        model.addAttribute("questionList", listToSort);



        return "index";
    }


    /**
     * Die Frage, welche angeklickt wird, wird auf einer eigenen Seite präsentiert und sie kann auch beantwortet werden
     *
     * @param id
     * @param model
     * @return
     */

    @GetMapping("/question/{id}")
    public String questionwithid(@PathVariable("id") int id, Model model){

        Question q1= qrep.findById((long)id).get();



        model.addAttribute("answer",new Answer());

        model.addAttribute("currentquestion",q1);


        return "currentquestion";
    }


    /**
     * Es wird eine Frage ausgewertet ob diese richtig oder falsch Beantwortet wurde. auch das Feedback wird hier zurückgegeben
     *
     * @param id
     * @param antwort
     * @param model
     * @return
     */


    @GetMapping("/question/{id}/increase")
    public String increse(@PathVariable("id") int id,@ModelAttribute("answer") Answer antwort, Model model){

        System.out.println();

        Question q1= qrep.findById((long)id).get();

        //Richtige Antwort wurde ausgewählt
        if(q1.getRightAnswer().equals(antwort.getAns())){
            q1.setRightCounter(q1.getRightCounter()+1);
            qrep.save(q1);

            model.addAttribute("currentquestion",q1);
            return "rightanswer";
        }
        else{
            return "falseanswer";
        }
    }


    @PostMapping("/question")
    public String question(@RequestParam String param){

       System.out.println(param);


        return "currentquestion";
    }




    @GetMapping("/impressum")
    public String impressum(){

        return "impressum";
    }
}
