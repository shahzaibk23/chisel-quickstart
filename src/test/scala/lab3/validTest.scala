// package lab3

// import org.scalatest._ 
// import chiseltest._ 
// import chisel3._ 
// import chisel3.util._
// import chiseltest.experimental.TestOptionBuilder._ 
// import chiseltest.internal.VerilatorBackendAnnotation

// class validTest extends FreeSpec with ChiselScalatestTester {
//     "Valid Test" in {
//         test(new Valid_Interf).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
//             c.io.in.poke(Valid(true.B))
//             c.clock.step(10)
//         }
//     }
// }