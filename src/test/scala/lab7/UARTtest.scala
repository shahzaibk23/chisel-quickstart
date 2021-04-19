package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class UARTtest extends FreeSpec with ChiselScalatestTester {
    "UART Test" in {
        test(new UART_Tx(UART_params())).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.en.poke(1.B)
            c.io.in.bits.poke(2.U)
            c.io.in.valid.poke(true.B)
            c.io.div.poke(3.U)
            c.io.nstop.poke(2.U)
            c.clock.step(20)
        }
    }
}