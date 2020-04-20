import {Answer} from './Answer';

export interface Quection {
  id: number;
  title: string;
  text: string;
  subjectId: number;
  lastModifiedstring: string;
  answerList: Answer[];
}
