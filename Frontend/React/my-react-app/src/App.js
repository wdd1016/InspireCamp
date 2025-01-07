import AppComponent from "./component/AppComponent";
import AppTraffic from "./component/AppTraffic";
import CommentList from "./component/CommentList";
import Counter from "./state/Counter";
import Say from "./state/Say";
import Todo from "./event/Todo";
import EventPractice from "./event/EventPractice";
import EventPracticeFunction from "./event/EventPracticeFunction";
import IterationSample from "./event/IterationSample";
import Drilling from "./state/Drilling";
import Hoisting from "./state/Hoisting";
import AddSub from "./state/AddSub";
import StateController from "./state/StateController";
import CelsiusFahrenheit from "./state/CelsiusFahrenheit";
import Form from "./Form";
import MyComponentRef from "./ref/MyComponentRef";
import PasswordChecker from "./ref/PasswordChecker";
import ScrollBox from "./ref/ScrollBox";
import IdPwChecker from "./ref/IdPwChecker";
import LifeCycleSample from "./lifecycle/LifeCycleSample";

function App() {
  return (
    <>
      {/* Component, Props */}
      {/* <AppComponent /> */}
      {/* <AppTraffic /> */}
      {/* <CommentList /> */}

      {/* State */}
      {/* <Counter /> */}
      {/* <Say /> */}
      {/* <Drilling /> */}
      {/* <Hoisting /> */}
      {/* <AddSub /> */}
      {/* <StateController /> */}
      {/* <CelsiusFahrenheit /> */}

      {/* Event Handling */}
      {/* <Todo /> */}
      {/* <EventPractice /> */}
      {/* <EventPracticeFunction /> */}
      {/* <IterationSample /> */}

      {/* Form */}
      {/* <Form /> */}

      {/* Ref */}
      {/* <MyComponentRef /> */}
      {/* <PasswordChecker /> */}
      {/* <ScrollBox /> */}
      {/* <IdPwChecker /> */}

      {/* LifeCycle */}
      <LifeCycleSample />
    </>
  );
}

export default App;