// package lab6

// import chisel3._ 
// import chisel3.util._ 

// class oneShotTimer extends Module {
//     val io = IO(new Bundle{
        
//         val out = Output(UInt(8.W))
//     })

//     val timer_count = RegInit(0.U(8.W))
//     val done = timer_count === 0.U
//     val next = WireInit(0.U)

//     when(reload){
//         next := din
//     }
// }