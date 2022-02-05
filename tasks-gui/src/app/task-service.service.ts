import { Injectable } from '@angular/core';
import { Task } from './Task';

@Injectable({
  providedIn: 'root'
})


export class TaskServiceService {

  constructor() { }


  getTasks(): Task[]{
    const tasks1: Task[] = [    
      {id: 1,toDo: "todo",toDoDetails: "details"  }
    ];

    return tasks1;
  }
      
}