import { Component } from '@angular/core';
import { TaskServiceService } from './task-service.service';
import { Task } from './Task';


@Component({
  selector: 'app-main',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  tasks : Task[] = [    
    {id: 3,toDo: "todo3",toDoDetails: "details3"  }
  ];

  constructor(private taskServ : TaskServiceService){
    
  }
  ngOnInit(): void {
    this.setTasks();
  }

  setTasks() : void {
     this.tasks =  this.taskServ.getTasks();
  }
  
}



