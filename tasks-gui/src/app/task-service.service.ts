import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from './Task';

@Injectable({
  providedIn: 'root'
})


@Injectable()
export class TaskServiceService {

  constructor(private httpClient : HttpClient ) { }

  private tasksUrl = "http://localhost:9051/tasks";
  

   tasks1: Task[] = [    
    {id: 1,toDo: "todo",toDoDetails: "details"  },
    {id: 3,toDo: "3 todo",toDoDetails: "3 details"  }
  ];

  getTasks(): Observable<Task[]>{     
      return this.httpClient.get<Task[]>(this.tasksUrl);
  }



  saveTasks(t: Task): Observable<Task>{    
     return this.httpClient.post<Task>(this.tasksUrl, t);
  }

  deleteTask(id: number){
    var deleteUrl= this.tasksUrl+"/"+id;
    return this.httpClient.delete(deleteUrl);
  }
      
  updateTask(taskObj: Task) : Observable<Task>{
    return this.httpClient.put<Task>(this.tasksUrl, taskObj);
  }
}