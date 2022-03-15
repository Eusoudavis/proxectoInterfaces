package  modelo.vo;

import lombok.Getter;

/**
 * Clase enum cos tipos de estado nos que pode estar unha conta
 */

@Getter
public enum Estado {
	ACTIVO,
	SUSPENDIDO;
	Estado() {
	}
}