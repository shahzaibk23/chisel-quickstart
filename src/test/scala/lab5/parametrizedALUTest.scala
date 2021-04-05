// package lab5

// import org.scalatest._ 
// import chiseltest._ 
// import chisel3._ 
// import chiseltest.experimental.TestOptionBuilder._ 
// import chiseltest.internal.VerilatorBackendAnnotation

// import scala.util.Random
// import chisel3.util._ 

// object ALUOP {
//     val ALU_ADD = 0.U(4.W)
//     val ALU_SUB = 1.U(4.W)
//     val ALU_AND = 2.U(4.W)
//     val ALU_OR  = 3.U(4.W)
//     val ALU_XOR = 4.U(4.W)
//     val ALU_SLT = 5.U(4.W)
//     val ALU_SLL = 6.U(4.W)
//     val ALU_SLTU= 7.U(4.W)
//     val ALU_SRL = 8.U(4.W)
//     val ALU_SRA = 9.U(4.W)
//     val ALU_COPY_A = 10.U(4.W)
//     val ALU_COPY_B = 11.U(4.W)
//     val ALU_XXX = 12.U(4.W) 
// }


// class ParamALUTest extends FreeSpec with ChiselScalatestTester {
    
//     "Parametrized ALU Test" in {
//         test(new ParamALU(32)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>

//             import ALUOP._ 
//             val array_op = Array(ALU_ADD, ALU_SUB, ALU_AND, ALU_OR, ALU_XOR, ALU_SLL,  ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B, ALU_XXX)
//             for(i <- 0 until 100){
//                 val src_a = Random.nextLong() & 0xFFFFFFFFL
//                 val src_b = Random.nextLong() & 0xFFFFFFFFL
//                 val opr = Random.nextInt(10)
//                 val aluop = array_op(opr)

//                 val index = log2Ceil(32)


//                 val result = opr match {

//                     case 0 => src_a & src_b
//                     case 1 => src_a | src_b
//                     case 2 => src_a + src_b
//                     case 6 => src_a - src_b
//                     case 3 => src_a ^ src_b
//                     // case 4 => src_a << src_b(index - 1, 0)
//                     // case 5 => src_a >> src_b(index - 1, 0)
//                     // case 7 => src_a.toInt >> src_b(index -1, 0)
//                     // case 8 => src_a.toInt < src_b.toInt
//                     // case 9 => src_a < src_b
//                     case _ => false
//                 }


//                 // val result = aluop match {
//                 //     case ALU_ADD => src_a + src_b
//                 //     case ALU_SUB => src_a - src_b
//                 //     case ALU_AND => src_a & src_b
//                 //     case ALU_OR => src_a | src_b
//                 //     case ALU_XOR => src_a ^ src_b
//                 //     // case ALU_SLT => (src_a.toInt < src_b.toInt).
//                 //     // case ALU_SLL => src_a << src_b(index - 1, 0)
//                 //     // case ALU_SLTU => (src_a < src_b).toInt
//                 //     // case ALU_SRL => src_a >> src_b(inde1w21aswax - 1, 0)
//                 //     // case ALU_SRA => src_a.toInt >> src_b(index - 1, 0)
//                 //     case ALU_COPY_A => src_a
//                 //     case ALU_COPY_B => src_b
//                 //     case _ => 0
//                 // }

//                 // val result1: BigInt = if (result < 0) (BigInt(0xFFFFFFFFL)+ result +1) & 0xFFFFFFFFL else result & 0xFFFFFFFFL
//                 val result1 = result
//                 c.io.arg_x.poke(src_a.U)
//                 c.io.arg_y.poke(src_b.U)
//                 c.io.alu_oper.poke(opr.U)
//                 c.clock.step(10)
//                 c.io.alu_out.expect(result1.asUInt)
//             }
//         }
//     }
// }