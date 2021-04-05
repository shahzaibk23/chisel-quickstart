package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random

// addi x2,x3,4             00418113
// sw x2,0(x0)              00202023
// lui, x3, 512             002001b7
// beq x0,x0,label1         00000463
// j label1                 0040006f
// label1:


class ImmGenTest extends FreeSpec with ChiselScalatestTester {
    "Immediate Generation Test" in {
        test(new ImmdValGen).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            val instArray = Array("h00418113", "h00202023", "h002001b7", "h00000463",  "h0040006f")
            for(i <- 0 until 100){
                val index = Random.nextInt(5)
                val inst = instArray(index).U

                val result = index match {
                    case 0 => 4 
                    case 1 => 0
                    case 2 => 2097152
                    case 3 => 8
                    case 4 => 4
                }

                c.io.instr.poke(inst)
                c.clock.step(10)
                c.io.immd_se.expect(result.U)

            }
        }
    }
}