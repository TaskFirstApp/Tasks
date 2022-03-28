import { Component, Input } from '@angular/core';
import { TaskServiceService } from './task-service.service';
import { Task } from './Task';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-main',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  tasks? : Task[] ;
  //@Input() task : Task = {id: 0, toDo:"", toDoDetails:"" };

  //@Input() task : Task = {} as Task;

  toDo = new FormControl('');
  toDoDetail = new FormControl('');

  detailsSection? : String ;

  constructor(private taskServ : TaskServiceService){
    
  }
  ngOnInit(): void {
    this.setTasks();
  }

  setTasks() : void {     
     this.taskServ.getTasks().subscribe((a: Task[])=> this.tasks = a );
  }

  saveTask() : void {
    this.taskServ.saveTasks({id: 0, toDo:this.toDo.value, toDoDetails:this.toDoDetail.value }).subscribe(
      
    );
  }

  showTask(t: Task) : void {
    this.detailsSection = t.toDoDetails;
  }

  
}



