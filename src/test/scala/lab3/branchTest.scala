package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random

class branchTest extends FreeSpec with ChiselScalatestTester {
    "Branch Test" in {
        test(new BranchControl).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            for(i <- 0 until 100){
                val src_a = Random.nextLong() & 0xFFFFFFFFL
                val src_b = Random.nextLong() & 0xFFFFFFFFL
                val opr = Random.nextInt(8)
                val br = Random.nextBoolean()
                // val src_a = 3
                // val src_b = 5
                // val opr = 3
                // val br = true


                val result = opr match {
                    case 0 => src_a.toInt == src_b.toInt
                    case 1 => src_a.toInt != src_b.toInt
                    case 3 => src_a.toInt < src_b.toInt
                    case 5 => src_a.toInt >= src_b.toInt
                    case 6 => src_a < src_b
                    case 7 => src_a >= src_b
                    case _ => false
                }

                c.io.funct3.poke(opr.U)
                c.io.arg_x.poke(src_a.U)
                c.io.arg_y.poke(src_b.U)
                c.io.branch.poke(br.B)
                c.clock.step(10)
                var taken = result && br
                c.io.br_taken.expect(taken.B)
            }

        }
    }
}