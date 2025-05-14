// let newbtn=document.createElement("button");
// newbtn.innerText="Click me!";
// newbtn.style.backgroundColor="red";
// newbtn.style.color="white";
// document.querySelector("body").prepend(newbtn);

// let para=document.querySelector("p");
// console.log(para.getAttribute("id"));
// console.log(para.setAttribute("class","content"));

// let btn=document.querySelector("#btn1");
// btn.onclick=()=>{
//     let a=5;
//     a++;
//     console.log(a);
// };

// let div=document.querySelector("#div1");
// div.onmouseover=()=>{
//     console.log("Hello you are in the div");
// };

// let btn=document.querySelector("#btn1");
// let currmode="LightMode";

// btn.addEventListener("mouseover",()=>{
//     if(currmode === "LightMode"){
//         currmode="DarkMode";
//         document.querySelector("body").classList.add("dark");
//         document.querySelector("body").classList.remove("light");
//     }
//     else{
//         currmode="LightMode";
//         document.querySelector("body").classList.add("light");
//         document.querySelector("body").classList.remove("dark");
//     }
//     console.log(currmode);
// });


// btn1.addEventListener("click",()=>{
//     console.log("Button was clicked 1");
// });

// btn1.addEventListener("click",()=>{
//     console.log("Button was clicked 2");
// });


// const btn3=()=>{
//     console.log("Button was clicked 3");
// };

// btn1.addEventListener("click",btn3);


// btn1.addEventListener("click",()=>{
//     console.log("Button was clicked 4");
// });

// btn1.removeEventListener("click",btn3);



// btn.onclick=(e)=>{
//     console.log(e);
// };

let userscore=0;
let compscore=0;

const choices=document.querySelectorAll(".choice");
const msg=document.querySelector("#msg");
const user_score_update=document.querySelector("#user-score");
const comp_score_update=document.querySelector("#comp-score");



const gencompchoice=()=>{
    const options=["Stone","Paper","Scissor"];
    const randidx=Math.floor(Math.random()*3);
    return options[randidx];
    

}

const showscore=(userwin)=>{
    if(userwin){
        userscore++;
        user_score_update.innerText=userscore;
        console.log("YOU WIN!");
        msg.innerText="You Win!";
    }
    else{
        compscore++;
        comp_score_update.innerText=compscore;
        console.log("YOU LOSE!");
        msg.innerText="You Lose!";
    }
};

const playgame=(userchoice)=>{
    console.log("Userchoice=",userchoice);
    const compchoice=gencompchoice();
    console.log("Compchoice=",compchoice);
    if(userchoice === compchoice){
        console.log("Match is draw");
        msg.innerText="Match is draw";
    }
    else{
        let userwin=true;
        if(userchoice === "Stone"){
            userwin=compchoice === "Paper"?false:true;
        }
        else if(userchoice === "Paper"){
            userwin=compchoice === "Scissor"?false:true;
        }
        else{
            userwin=compchoice === "Stone"?false:true;
        }
        showscore(userwin);
}
};

choices.forEach((choice) => {
    choice.addEventListener("click",()=>{
        const userchoice=choice.getAttribute("id");
        playgame(userchoice);

    });

    
});


