package model;

import model.entity.Process;
import model.entity.User;
import model.specification.process.AllProcessesSpecification;
import model.specification.process.ProcessByNameSpecification;
import model.specification.user.UserByNameSpecification;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ProcessModel implements IProsessModel{
    private Process process=new Process();
    private String owner;
    public ProcessModel(String type, String name, String phase, String status,
                        String objective, String owner, String period,
                        String duration, String subType) {
        this.owner=owner;
        process.setPeriod(Integer.parseInt(period));
        process.setDuration(splitDate(duration));
        process.setType(type);
        process.setName(name);
        process.setObjective(objective);
        process.setPhase(phase);
        process.setStatus(status);
        process.setSubType(subType);
    }

    private LocalDate splitDate(String duration){
        int year=new Integer(duration.substring(0,4));
        //mb ubrat' 0

        Month month=Month.of(new Integer(duration.substring(5,7)));
        int day;
        if(duration.substring(8).contains("0")){
            day=new Integer(duration.substring(8,9));
        } else {
            day=new Integer(duration.substring(8));
        }
        return LocalDate.of(year, month,day);
    }

    @Override
    public void pushProcess() {
        List<User> user=  userRepo.query(new UserByNameSpecification(owner));
            process.setOwner(user.get(0));
        List<Process> proc=procRepo.query(new ProcessByNameSpecification(process.getName()));
        if(proc.isEmpty()){
            procRepo.add(process);
        } else {
            process.setId(proc.get(0).getId());
            procRepo.update(process);
        }

    }

}
