package lab1

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation


class exercise3Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 3 Test" in {
        test(new Counter5(2, 12)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            // c.io.in.poke(true.B)
            c.clock.step(20)
            // c.io.result.expect(1.B)
        }
    }
}